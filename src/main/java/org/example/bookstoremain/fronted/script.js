const cart = [];

document.addEventListener('DOMContentLoaded', () => {
    const addToCartButtons = document.querySelectorAll('.add-to-cart');

    addToCartButtons.forEach(button => {
        button.addEventListener('click', () => {
            const bookTitle = button.dataset.title;
            const bookPrice = button.dataset.price;
            addToCart(bookTitle, bookPrice);
        });
    });

    const orderForm = document.getElementById('orderForm');
    if (orderForm) {
        orderForm.addEventListener('submit', handleOrderSubmit);
    }
});

function addToCart(title, price) {
    cart.push({ title, price });
    alert(`${title} добавлена в корзину!`);
}

async function handleOrderSubmit(event) {
    event.preventDefault();

    const name = event.target.name.value;
    const address = event.target.address.value;
    const pickupLocation = event.target.pickupLocation.value;

    if (cart.length === 0) {
        alert('Ваша корзина пуста!');
        return;
    }

    const orderData = {
        name: name,
        address: address,
        pickupLocation: pickupLocation,
        items: cart
    };

    try {
        const response = await fetch('/api/v1/orders', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(orderData)
        });

        if (!response.ok) {
            throw new Error('Ошибка при отправке заказа');
        }

        alert('Заказ оформлен успешно!');
        cart.length = 0;
        event.target.reset();
    } catch (error) {
        console.error('Ошибка:', error);
        alert('Не удалось оформить заказ. Попробуйте еще раз.');
    }
}