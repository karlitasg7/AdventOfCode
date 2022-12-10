function checkJump(heights) {
    let r = heights.reverse().findIndex((val, i) => val > heights[i + 1]);
    let l = heights.reverse().findIndex((val, i) => val > heights[i + 1]);
    r = heights.length - r - 1;
    return l !== -1 && r !== -1 && r <= l;
}

console.log(checkJump([1, 3, 8, 5, 2])); // true
console.log(checkJump([1, 7, 3, 5])); // false
console.log(checkJump([2, 2, 2, 2])); // false
console.log(checkJump([1, 2, 3])); // false
