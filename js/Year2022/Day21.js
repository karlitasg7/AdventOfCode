function printTable(gifts) {

    let maxLengthName = gifts
        .map(x => x.name.length)
        .sort((a, b) => b - a)[0];

    let maxLengthQuantity = gifts
        .map(x => x.quantity.toString().length)
        .sort((a, b) => b - a)[0];

    if (maxLengthName < 4) {
        maxLengthName = 4;
    }

    if (maxLengthQuantity < 8) {
        maxLengthQuantity = 8;
    }

    let table = "+".repeat(maxLengthName + maxLengthQuantity + 7) + '\n';

    // headers
    table += '| Gift' + ' '.repeat(maxLengthName - 4) +
        ' | Quantity' + ' '.repeat(maxLengthQuantity - 8) +
        ' |\n';
    table += '| ' + '-'.repeat(maxLengthName) +
        ' | ' + '-'.repeat(maxLengthQuantity) +
        ' |\n';

    // detail
    gifts.forEach(x => {
        table += '| ' + x.name +
            ' '.repeat(maxLengthName - x.name.length) +
            ' | ' + x.quantity +
            ' '.repeat(maxLengthQuantity - x.quantity.toString().length) +
            ' |\n';
    });

    // footer
    table += "*".repeat(maxLengthName + maxLengthQuantity + 7);

    return table;
}

console.log(printTable([
    {name: 'Game', quantity: 2},
    {name: 'Bike', quantity: 1},
    {name: 'Book', quantity: 3}
]));
/*

+++++++++++++++++++
| Gift | Quantity |
| ---- | -------- |
| Game | 2        |
| Bike | 1        |
| Book | 3        |
*******************

 */

console.log(printTable([
    {name: 'PlayStation 5', quantity: 9234782374892},
    {name: 'Book Learn Web Dev', quantity: 23531}
]));
