const fs = require('fs');
const path = require('path');
const request = require('syncrequest');
const cheerio = require('cheerio');
const mysql = require('mysql');
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'springuser',
  password: 'ThePassword',
  database: 'book_store',
});
const log = console.log;

class Book {
  constructor() {
    this.name = '';
    this.score = 0;
    this.quote = '';
    this.numberOfComments = 0;
    this.author = '';
    this.press = '';
    this.price = 0;
    this.year = 0;
  }
}

const bookFromTable = table => {
  let e = cheerio.load(table);
  let book = new Book();
  book.name = e('.pl2')
    .find('a')
    .attr('title');
  book.score = Number(e('.rating_nums').text());
  book.quote = e('.inq').text();
  book.numberOfComments = Number(
    e('.star')
      .find('.pl')
      .text()
      .slice(22, -21),
  );
  let info = e('p[class=pl]')
    .text()
    .split(' / ');
  console.log(info);
  let imgSrc = e('.nbg img').attr('src');
  book.imgSrc = imgSrc;
  let infoLength = info.length;
  book.author = info[0];
  book.price = info[infoLength - 1];
  book.year = Number(info[infoLength - 2].slice(0, 4));
  book.press = info[infoLength - 3];
  return book;
};

const getBooksFromUrl = url => {
  let res = request.get.sync(url);
  let body = res.body;
  let e = cheerio.load(body);
  let bookTables = e('.item');
  let books = [];
  for (let i = 0; i < bookTables.length; i++) {
    let table = bookTables[i];
    let b = bookFromTable(table);
    books.push(b);
  }
  return books;
};

const savebook = async books => {
  let s = JSON.stringify(books, null, 2);
  // books.map((book, index) => {
  //   downloadPic(book.imgSrc, `./imgs/${index}.jpg`);
  // });
  let path = 'douban.json';
  fs.writeFileSync(path, s);
};

const downloadPic = (src, dest) => {
  request(src)
    .pipe(fs.createWriteStream(dest))
    .on('close', function() {
      console.log('pic saved!');
    });
};

const saveToDB = books => {
  connection.connect();
  // 数据库表结构待调整，暂时先放着
  let addSql =
  'INSERT INTO book(name,author,press,price,score,comment_num,image,description,category_id) VALUES(?,?,?,?,?,?,?,?,?)';
books.map((book,index) => {
  let addParams = [
    book.name,
    book.author,
    book.press,
    parseFloat(book.price),
    parseFloat(book.score),
    book.numberOfComments,
    index.toString(),
    book.quote,
    book.year,
  ];
    connection.query(addSql, addParams, (err, result) => {
      if (err) {
        log(`ERROR:${err.message}`);
      }
    });
  });
  connection.end();
};
const runSpider = () => {
  let books = [];
  for (let page = 0; page < 10; page++) {
    log(`loading from  page ${page}`);
    let start = page * 25;
    let url = `https://book.douban.com/top250?start=${start}`;
    let booksInPage = getBooksFromUrl(url);
    books = books.concat(booksInPage);
  }
  savebook(books);
   saveToDB(books);
  log('loading success');
};
const init = () => {
  const imgRoot = path.resolve(process.cwd(), 'imgs');
  if (!fs.existsSync(imgRoot)) {
    fs.mkdirSync(imgRoot);
  }
  runSpider();
};
init();
