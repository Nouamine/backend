document.querySelectorAll('.close-btn').forEach(button => {
    button.addEventListener('click', () => {
        const notification = button.parentElement;
        notification.style.opacity = '0';
        setTimeout(() => notification.style.display = 'none', 300);
    });
});