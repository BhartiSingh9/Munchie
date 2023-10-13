angular.module('myApp').service('cartService', function () {
    const cart = [];

    this.addToCart = function (dish) {
        const existingItem = cart.find(item => item.dish.id === dish.id);

        if (existingItem) {
            existingItem.dish.quantity++;
        } else {
            cart.push({ dish, quantity: 1 });
        }
    };

    this.incrementQuantity = function (dish) {
        const cartItem = cart.find(item => item.dish.id === dish.id);
        if (cartItem) {
            cartItem.quantity++;
        }
    };

    this.decrementQuantity = function (dish) {
        const cartItem = cart.find(item => item.dish.id === dish.id);
        if (cartItem && cartItem.quantity > 0) {
            cartItem.quantity--;
        }
    };

    this.getCartItems = function () {
        return cart;
    };

    this.removeFromCart = function (cartItem) {
        const index = cart.indexOf(cartItem);
        if (index !== -1) {
            cart.splice(index, 1);
        }
    };

    this.getTotalCost = function () {
        let total = 0;
        cart.forEach(item => {
            total += item.dish.price * item.quantity;
        });
        return total;
    };
});
