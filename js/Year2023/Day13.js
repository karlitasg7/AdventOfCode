function calculateTime(deliveries) {

    deliveries = deliveries.map(delivery => {
        const [h, m, s] = delivery.split(':');
        return h * 3600 + m * 60 + s * 1;
    });

    const total = (deliveries.reduce((acc, cur) => acc + cur, 0));

    if (total !== 0) {
        const totalLeftOver = Math.abs(25200 - total);
        const h = Math.floor(totalLeftOver / 3600);
        const m = Math.floor((totalLeftOver % 3600) / 60);
        const s = totalLeftOver % 60;
        const symbol = total < 25200 ? '-' : '';

        return `${symbol}${h < 10 ? '0' + h : h}:${m < 10 ? '0' + m : m}:${s < 10 ? '0' + s : s}`;
    }

    return '00:00:00'
}

console.log(calculateTime(['00:10:00', '01:00:00', '03:30:00'])); // '-02:20:00'

console.log(calculateTime(['02:00:00', '05:00:00', '00:30:00'])); // '00:30:00'

console.log(calculateTime([
    '00:45:00',
    '00:45:00',
    '00:00:30',
    '00:00:30'
])); // '-05:29:00'
