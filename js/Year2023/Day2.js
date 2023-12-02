function manufacture(gifts, materials) {
    return gifts.filter(gift => {
        return gift.split('').every(c => materials.includes(c))
    })
}

console.log(manufacture(['train', 'bear', 'ball'], 'tronesa')) // ["", ""]
console.log(manufacture(['game', 'puzzle'], 'jlepuz')) // ["puzzle"]
console.log(manufacture(['book', 'ps5'], 'psli')) // []
