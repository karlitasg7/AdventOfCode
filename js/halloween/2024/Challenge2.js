/*
  https://www.halloween.dev/es/retos/2024/2
*/

function battleHorde(zombies, humans) {
  let previousZombie = 0;
  let previousHuman = 0;

  for (let i = 0; i < zombies.length; i++) {
    const zombieAttack = parseInt(zombies[i]) + previousZombie;
    const humanAttack = parseInt(humans[i]) + previousHuman;

    if (zombieAttack > humanAttack) {
      previousHuman = 0;
      previousZombie = zombieAttack - humanAttack;
    } else if (zombieAttack < humanAttack) {
      previousHuman = humanAttack - zombieAttack;
      previousZombie = 0;
    } else {
      previousZombie = 0;
      previousHuman = 0;
    }
  }

  if (previousZombie > previousHuman) {
    return `${previousZombie}z`;
  }

  if (previousHuman > previousZombie) {
    return `${previousHuman}h`;
  }

  return "x";
}

const zombies = "242";
const humans = "334";

// primera ronda: zombie 2 vs human 3 -> humano gana (+1)
// segunda ronda: zombie 4 vs human 3+1 -> empate
// tercera ronda: zombie 2 vs human 4 -> humano gana (+2)
// resultado: "2h"
console.log(battleHorde(zombies, humans)); // -> "2h"

console.log(battleHorde("444", "282")); // x
