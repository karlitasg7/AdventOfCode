function dryNumber(dry, numbers) {

    let newArr = [];

    for (let i = 1; i <= numbers; i++) {
        if (i.toString().includes(dry.toString())) {
            newArr.push(i);
        }
    }
    return newArr;
}

console.log(dryNumber(1, 15)); // [1, 10, 11, 12, 13, 14, 15]

// no tenemos tinta para el 1
// tenemos que imprimir 15 códigos de barras del 1 al 15
// los códigos de barras que saldrán mal por falta de tinta son:
// 1, 10, 11, 12, 13, 14, 15

console.log(dryNumber(2, 20)); // [2, 12, 20]

// no tenemos tinta para el 2
// tenemos que imprimir 20 códigos de barras del 1 al 20
// los códigos de barras que saldrán mal por falta de tinta son:
// 2, 12, 20
