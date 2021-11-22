
const str = "CDE Name 3 45+1 S SubName";
const match = str.match(/([a-zA-Z\s]*)(\d+)[+]?(\d*).([G,Y,R,S])([a-zA-Z\s]*)/)

console.log(match);
