function decorateTree(base) {

    let tree = [];
    tree.push(base);

    let mapLetter = {
        'BB': 'B',
        'RR': 'R',
        'PP': 'P',
        'BP': 'R',
        'PB': 'R',
        'RP': 'B',
        'PR': 'B',
        'BR': 'P',
        'RB': 'P',
    };

    let lastLine = base;
    while (lastLine.length > 1) {

        let arrCurrentLine = lastLine.split(" ");

        let newLine = '';
        for (let i = 0; i < arrCurrentLine.length - 1; i++) {
            let newChar = arrCurrentLine[i] + arrCurrentLine[i + 1];
            newLine += mapLetter[newChar] + " ";
        }
        newLine = newLine.trim();
        tree.push(newLine)
        lastLine = newLine;

    }

    return tree.reverse();
}

console.log(decorateTree('B P R P'));
// [
// 'R',
// 'P B',
// 'R B B',
// 'B P R P'
// ]

console.log(decorateTree('B B')); // ['B', 'B B']
