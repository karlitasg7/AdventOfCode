/*
  https://www.halloween.dev/es/retos/2024/3
*/

function findSafestPath(dream) {
  const n = dream.length;
  const m = dream[0].length;

  const dreamDanger = Array.from({ length: n }, () =>
    Array.from({ length: m }, () => 0)
  );
  dreamDanger[0][0] = dream[0][0];

  for (let row = 1; row < n; row++) {
    dreamDanger[row][0] = dreamDanger[row - 1][0] + dream[row][0];
  }

  for (let col = 1; col < m; col++) {
    dreamDanger[0][col] = dreamDanger[0][col - 1] + dream[0][col];
  }

  for (let row = 1; row < n; row++) {
    for (let col = 1; col < m; col++) {
      dreamDanger[row][col] =
        Math.min(dreamDanger[row - 1][col], dreamDanger[row][col - 1]) +
        dream[row][col];
    }
  }

  return dreamDanger[n - 1][m - 1];
}

const dream = [
  [1, 3, 1],
  [1, 5, 1],
  [4, 2, 1],
];

console.log(findSafestPath(dream)); // Devuelve 7
// El mejor camino es:
// [0, 0] -> 1
// [0, 1] -> 3
// [0, 2] -> 1
// [1, 2] -> 1
// [2, 2] -> 1

// 1 -> 3 -> 1 -> 1 -> 1 = 7
