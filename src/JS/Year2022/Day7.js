function getGiftsToRefill(a1, a2, a3) {
    return [...new Set([...a1, ...a2, ...a3])]
        .filter(r => a1.includes(r) + a2.includes(r) + a3.includes(r) === 1);
}

const a1 = ['bici', 'coche', 'bici', 'bici']
const a2 = ['coche', 'bici', 'muñeca', 'coche']
const a3 = ['bici', 'pc', 'pc']

/* El almacén a1 tiene "bici" y "coche".
El almacén a2 tiene "coche", "bici" y "muñeca".
El almacén a3 tiene "bici" y "pc".

El regalo "muñeca" y "pc" sólo están en los almacenes a2 y a3 respectivamente.
*/

console.log(getGiftsToRefill(a1, a2, a3)); // ['muñeca', 'pc']
console.log(getGiftsToRefill([], a2, a3));
