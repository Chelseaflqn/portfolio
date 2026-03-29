let targetNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;

function checkGuess() {
    const input = document.getElementById('guessInput');
    const message = document.getElementById('game-message');
    const attemptsCount = document.getElementById('attempts-count');

    const guess = parseInt(input.value);

    if (isNaN(guess) || guess < 1 || guess > 100) {
        message.textContent = "⚠️ Entrez un nombre entre 1 et 100.";
        message.style.color = "orange";
        return;
    }

    attempts++;
    attemptsCount.textContent = attempts;

    if (guess < targetNumber) {
        message.textContent = "Trop petit !";
        message.style.color = "blue";
    } else if (guess > targetNumber) {
        message.textContent = "Trop grand !";
        message.style.color = "red";
    } else {
        message.textContent = `Bravo ! Vous avez trouvé en ${attempts} tentative(s) !`;
        message.style.color = "green";
    }

    input.value = '';
    input.focus();
}

function resetGame() {
    targetNumber = Math.floor(Math.random() * 100) + 1;
    attempts = 0;
    document.getElementById('attempts-count').textContent = 0;
    document.getElementById('game-message').textContent = '';
    document.getElementById('guessInput').value = '';
}