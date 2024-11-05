// https://www.halloween.dev/es/retos/2024/1

function createMagicPotion(potions, target) {
  if (potions.length <= 1) {
    return undefined;
  }

  let map = new Map();
  for (let i = 0; i < potions.length; i++) {
    let complement = target - potions[i];
    if (map.has(complement)) {
      return [map.get(complement), i];
    }
    map.set(potions[i], i);
  }

  return undefined;
}

console.log(createMagicPotion([4, 5, 6, 2], 8)); // [2, 3]
console.log(createMagicPotion([1, 2, 3, 4], 9)); // undefined
console.log(createMagicPotion([1, 2, 3, 4], 5)); // [1, 2]
console.log(createMagicPotion([4, 3, 2, 3, 4], 6)); // [0, 2]
