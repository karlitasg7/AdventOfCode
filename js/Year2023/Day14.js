function maxGifts(houses) {

    const dp = houses.slice(0, 2);

    for (const house of houses.slice(2)) {
        dp.push(Math.max(...dp.slice(0, -1)) + house);
    }
    return Math.max(...dp);
}

console.log(maxGifts([2, 4, 2])); // 4 (4)
console.log(maxGifts([5, 1, 1, 5])); // 10 (5 + 5)
console.log(maxGifts([4, 1, 1, 4, 2, 1])); // 9 (4 + 4 + 1)
console.log(maxGifts([1, 3, 1, 3, 100])); // 103 (3 + 100)
