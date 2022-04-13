var express = require('express');
var app = express(); 

app.use(express.json());
app.use(express.urlencoded({extended:false}));


//---------------------------------------------------------
// 1차 경로
var router = express.Router();
app.use('/tiger', require('./routes/tiger'))

//---------------------------------------------------------
var port = process.env.PORT || '5000' ;  
app.listen(port, ()=> {console.log('listen');}); 

module.exports = app;