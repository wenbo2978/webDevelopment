//localStorage.removeItem('cart');

export let cart = JSON.parse(localStorage.getItem('cart'));

if(!cart){
  cart = [{
    productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
    quantity: 2,
    deliveryOptionId: '1'
  },
  {
    productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
    quantity: 1,
    deliveryOptionId: '2'
  }];
}



export let cartQuantity = getCartQuantity();

function getCartQuantity(){
  let q = 0;
  cart.forEach((c) => {
    q += c.quantity;
  });
  return q;
}


function updateCartQuantity(){
  const element = document.querySelector('.js-checkout-item-quantity');
  //console.log(element);
  if(element){
    element.innerHTML = `${cartQuantity} items`;
  }
}

function saveToStorage(){
  localStorage.setItem('cart', JSON.stringify(cart));
}

updateCartQuantity();


//let cartQuantity = 0;
const cartMap = new Map();

export function addToCart(productId){
  const selectElement = document.querySelector('.js-select-' + productId);
    const productQ = Number(selectElement.value);
    let matchingItem;
    cart.forEach((item) => {
      if(productId === item.productId){
        matchingItem = item;
      }
    });
    if(matchingItem){
      matchingItem.quantity += productQ;
    }else{
      cart.push({
        productId: productId,
        quantity: productQ,
        deliveryOptionId: '1'
      });
      
    }
    cartQuantity += productQ;
    document.querySelector('.js-cart-quantity').innerHTML = cartQuantity;

    saveToStorage();
    updateCartQuantity();
}

export function addToCartImage(productId){
  document.querySelector('.js-added-to-cart-' + productId).style.opacity = "1";
    
    const timeId = setTimeout(()=> {
      document.querySelector('.js-added-to-cart-' + productId).style.opacity = "0";
      clearTimeout(cartMap.get(productId));
    }, 2000);
    
    if(cartMap.get(productId)){
      clearTimeout(cartMap.get(productId));
    }
    cartMap.set(productId, timeId);
}


export function removeFromCart(productId){
  const newCart = [];
  cart.forEach((cartItem) => {
    if(cartItem.productId !== productId){
      newCart.push(cartItem);
      
    }else{
      cartQuantity -= cartItem.quantity;
    }
  });
  cart = newCart;
  saveToStorage();
  updateCartQuantity();
}

export function updateDeliveryOption(productId, deliveryOptionId){
  let matchingItem;
  cart.forEach((item) => {
    if(productId === item.productId){
      matchingItem = item;
    }
  });

  matchingItem.deliveryOptionId = deliveryOptionId;
  saveToStorage();
}

export function updateProductQuantity(productId, updatedQuantity){
  cart.forEach((item) => {
    if(item.productId === productId){
      cartQuantity = cartQuantity - item.quantity;
      item.quantity = updatedQuantity;
      cartQuantity = cartQuantity + item.quantity;
    }
  });
  saveToStorage();
  updateCartQuantity();
}