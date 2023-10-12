//https://www.hackerrank.com/challenges/equality-in-a-array/problem
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

const readLine = () =>inputString[currentLine++];

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', () => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

const equalizeArray = (arr) => {
  const occurences = {};
  let max = 1;

  arr.forEach(value => {
    if (!occurences[value]) {
      occurences[value] = 1;
    } else {
      occurences[value]++;
      if (occurences[value] > max) {
        max = occurences[value];
      }
    }
  })

  return arr.length - max;
}

const main = () => {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);
    const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

    ws.write(equalizeArray(arr) + "\n");
    ws.end();
}
