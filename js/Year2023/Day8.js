function organizeGifts(gifts) {

    const mapGifs = new Map()

    let lastNumber = ''

    gifts
        .split('')
        .forEach(g => {
            if (isNaN(g)) {
                mapGifs.set(lastNumber, g)
                lastNumber = ''
            } else {
                lastNumber += g
            }
        });

    let result = ''

    const giftsOnPallet = 50
    const giftsOnBox = 10

    mapGifs.forEach((value, key) => {

        const numberOfGifts = key;

        const quantityOfPallet = Math.floor(numberOfGifts / giftsOnPallet);
        const quantityOfBoxes = Math.floor(
            (numberOfGifts - (quantityOfPallet * giftsOnPallet))
            / giftsOnBox
        );

        if (quantityOfPallet > 0) {
            result += `[${value}]`.repeat(quantityOfPallet)
        }

        if (quantityOfBoxes > 0) {
            result += `{${value}}`.repeat(quantityOfBoxes)
        }

        const quantityOfBags = numberOfGifts -
            (quantityOfPallet * giftsOnPallet) -
            (quantityOfBoxes * giftsOnBox)

        if (quantityOfBags > 0) {
            result += `(${value.repeat(quantityOfBags)})`
        }

    })

    return result;
}

const result1 = organizeGifts('76a11b')
console.log(result1)
// `[a]{a}{a}(aaaaaa){b}(b)`

/* Explanation:

  76a: 76 gifts type 'a' would be packed in 7 boxes and 6 gifts would be left, resulting in 1 pallet [a] (for the first 5 boxes), 2 loose boxes {a}{a} and a bag with 6 gifts (aaaaaa)

  11b: 11 gifts type 'b' would be packed in 1 box and 1 gift would be left, resulting in 1 loose box {b} and a bag with 1 gift (b)

 */
