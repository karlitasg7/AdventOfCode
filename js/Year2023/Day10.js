function createChristmasTree(ornaments, height) {

    let result = ''
    let count = 0;

    for (let i = 0; i < height; i++) {
        result += ' '.repeat(height - i - 1)

        for (let j = 0; j < i + 1; j++) {
            let symbol = ornaments[count];
            count++;

            if (count === ornaments.length) count = 0;

            if (j === i) {
                result += `${symbol}`;
                break;
            }
            result += `${symbol} `;
        }
        result += '\n';
    }

    result += ' '.repeat(height - 1) + '|\n';

    return result
}

console.log(createChristmasTree("123", 4))
console.log(createChristmasTree("*@o", 3))
