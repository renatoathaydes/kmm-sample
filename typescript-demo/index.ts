import { hexa } from './libs/hexadecimal';

console.log(hexa.parseHexadecimal("1234556700dfdfab3"));

hexa.nonSuspendedFunction(10, (n, error) => {
    if (error != null) {
        console.error(error);
    } else if (n != null) {
        console.log(`Got number ${n} of type ${typeof n}`);
    }
});