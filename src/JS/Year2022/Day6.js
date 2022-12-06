function createCube(size) {

    let cube1 = [];
    let cube2 = [];

    for (let i = 0; i < size; i++) {
        let blankSpaceNeeded = (size - i - 1);
        cube1.push(`${' '.repeat(blankSpaceNeeded)}${'/\\'.repeat(i)}/${'\\_'.repeat(size)}\\`);
        cube2.push(`${' '.repeat(i)}\\${('/\\'.repeat(blankSpaceNeeded))}${'/_'.repeat(size)}/`);
    }

    return cube1.concat(cube2).join('\n');
}

console.log(createCube(3));
/*

  /\_\_\_\
 /\/\_\_\_\
/\/\/\_\_\_\
\/\/\/_/_/_/
 \/\/_/_/_/
  \/_/_/_/

 */


console.log(createCube(1));
/*

/\_\
\/_/

 */

console.log(createCube(2));
/*
 /\_\_\
/\/\_\_\
\/\/_/_/
 \/_/_/
 */
