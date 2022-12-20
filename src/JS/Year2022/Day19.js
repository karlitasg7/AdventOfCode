function sortToys(toys, positions) {

    let newArr = [];

    for (let i = 0; i < positions.length; i++) {
        newArr[positions[i]] = toys[i];
    }

    return newArr.filter(x => x !== '');
}

const toys = ['ball', 'doll', 'car', 'puzzle']
const positions = [2, 3, 1, 0]

console.log(sortToys(toys, positions));
// ['puzzle', 'car', 'ball', 'doll']

const moreToys = ['pc', 'xbox', 'ps4', 'switch', 'nintendo']
const morePositions = [8, 6, 5, 7, 9]

console.log(sortToys(moreToys, morePositions));
// ['ps4', 'xbox', 'switch', 'pc', 'nintendo']
