import hexadecimal from '../../hexadecimal/build/distributions/hexadecimal.js';

window.onload = () => {
    const input = document.getElementById('text-input');
    const output = document.getElementById('hex-output');
    updateOutput(input, output);
    input.onkeyup = () => {
        updateOutput(input, output);
    };
};

function updateOutput(input, output) {
    output.textContent = hexadecimal.hexa.parseHexadecimal(input.value).toString();
}
