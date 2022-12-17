function carryGifts(gifts, maxWeight) {

    if (gifts.every(n => n.length > maxWeight)) return []

    let newArray = [];
    let currentGift = '';
    let currentWeight = 0;
    gifts.forEach(element => {

        let w = element.length;

        if ((currentWeight + w) <= maxWeight) {
            currentGift += element + ' ';
            currentWeight += w;
        } else {
            if (currentGift.trim() !== '') {
                newArray.push(currentGift.trim());
                currentGift = '';
                currentWeight = 0;
            }

            currentGift += element + ' ';
            currentWeight += w;

        }

    });

    if (currentGift !== '') {
        newArray.push(currentGift.trim());
    }

    return newArray;
}

console.log(carryGifts(['game', 'bike', 'book', 'toy'], 10));
// ['game bike', 'book toy']
// en cada saco se puede llevar 10kg
// el primer saco lleva 'game' y 'bike' que pesan 4kg y 4kg
// el segundo saco lleva 'book' y ' toy' que pesan 4kg y 3kg

console.log(carryGifts(['game', 'bike', 'book', 'toy'], 7));
// ['game', 'bike', 'book toy']
// en cada saco se puede llevar 7kg
// el primer saco sólo puede llevar 'game' que pesa 4kg
// el segundo saco sólo puede llevar 'bike' que pesa 4kg
// el tercer saco lleva 'book' y 'toy' que pesan 4kg y 3kg

console.log(carryGifts(['game', 'bike', 'book', 'toy'], 4));
// ['game', 'bike', 'book', 'toy']
// en cada saco se puede llevar 4kg
// cada saco sólo puede llevar un regalo

console.log(carryGifts(['toy', 'gamme', 'toy', 'bike'], 6));
// ['toy', 'gamme', 'toy', 'bike']
// en cada saco se puede llevar 6kg
// cada saco sólo puede llevar un regalo
// fíjate que no se puede llevar 'toy toy' en un saco
// porque no está uno al lado del otro

console.log(carryGifts(['toy', 'toy', 'toy', 'toy'], 2));
