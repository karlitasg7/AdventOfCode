function fitsInOneBox(boxes) {
    return boxes
        .sort((a, b) => a.l - b.l)
        .every(({l, w, h}, index, currentBoxes) => {
            if (index === currentBoxes.length - 1) return true;
            const canBoxBeFit = l < currentBoxes[index + 1].l && w < currentBoxes[index + 1].w && h < currentBoxes[index + 1].h

            return canBoxBeFit
        });

}

const boxes = [
    {l: 1, w: 1, h: 1},
    {l: 2, w: 2, h: 2},
    {l: 3, w: 1, h: 3}
]

console.log(fitsInOneBox(boxes)); // false

const boxes2 = [
    {l: 1, w: 1, h: 1},
    {l: 3, w: 3, h: 3},
    {l: 2, w: 2, h: 2}
]

console.log(fitsInOneBox(boxes2)); // true
