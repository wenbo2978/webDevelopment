import {cart, cartQuantity, removeFromCart, updateDeliveryOption, updateProductQuantity} from '../../data/cart.js'
import {products, getProduct} from '../../data/products.js'
import {formatCurrency} from '../utils/money.js'
import dayjs from 'https://unpkg.com/dayjs@1.11.10/esm/index.js';
import {deliveryOptions, getDeliveryOption} from '../../data/deliveryOptions.js'
import { renderPaymentSummary } from './paymentSummary.js';
import { renderCheckoutHeader } from './checkoutHeader.js';


/*const today = dayjs();
const deliveryDate = today.add(7, 'days');

console.log(deliveryDate);

console.log(deliveryDate.format('dddd, MMMM, D, YYYY'));

console.log("111");
*/

export function renderOrderSummary(){



  let cartSummaryHTML = '';

  cart.forEach((cartItem) => {
    const productId = cartItem.productId;

    let matchingProduct = getProduct(productId);
    

    const deliveryOptionId = cartItem.deliveryOptionId;

    let deliveryOption = getDeliveryOption(deliveryOptionId);

    const today = dayjs();
      
    const deliveryDate = today.add(
      deliveryOption.deliveryDays,
      'days'
    );
    const dateString = deliveryDate.format(
      'dddd, MMMM D'
    );

    let html = `<div class="cart-item-container js-cart-item-container-${matchingProduct.id}">
      <div class="delivery-date">
        Delivery date: ${dateString}
      </div>

      <div class="cart-item-details-grid">
        <img class="product-image"
          src="${matchingProduct.image}">

        <div class="cart-item-details">
          <div class="product-name">
            ${matchingProduct.name}
          </div>
          <div class="product-price">
            $${formatCurrency(matchingProduct.priceCents)}
          </div>
          <div class="product-quantity">
            <span>
              Quantity: <span class="quantity-label">${cartItem.quantity}</span>
            </span>
            <span class="update-quantity-link link-primary js-update-link js-update-${matchingProduct.id}" data-product-id="${matchingProduct.id}">
              Update
            </span>
            <input class="quantity-input js-input-update-${matchingProduct.id} js-quantity-input" data-product-id="${matchingProduct.id}">

            <span class="save-quantity-link link-primary js-save-${matchingProduct.id} js-save-link" data-product-id="${matchingProduct.id}">
              Save
            </span>
            <span class="delete-quantity-link link-primary js-delete-link" data-product-id="${matchingProduct.id}">
              Delete
            </span>
          </div>
        </div>

        <div class="delivery-options">
          <div class="delivery-options-title">
            Choose a delivery option:
          </div>
          
          
          ${deliveryOptionsHTML(matchingProduct, cartItem)}
        </div>
      </div>
    </div>`;
    cartSummaryHTML += html;
  });

  function deliveryOptionsHTML(matchingProduct, cartItem){
    let html = '';
    deliveryOptions.forEach((deliveryOption)=>{
      const today = dayjs();
      
      const deliveryDate = today.add(
        deliveryOption.deliveryDays,
        'days'
      );
      const dateString = deliveryDate.format(
        'dddd, MMMM D'
      );
      //console.log(deliveryOption.deliveryDays);
      const priceString = deliveryOption.priceCents === 0 
        ? 'Free'
        : `${formatCurrency(deliveryOption.priceCents)}`
      const isChecked = deliveryOption.id === cartItem.deliveryOptionId;

      html += `
        <div class="delivery-option js-delivery-option" data-product-id="${matchingProduct.id}" data-delivery-option-id="${deliveryOption.id}">
          <input type="radio" 
            ${isChecked ? 'checked': ''}
            class="delivery-option-input"
            name="delivery-option-${matchingProduct.id}">
          <div>
            <div class="delivery-option-date">
              ${dateString}
            </div>
            <div class="delivery-option-price">
              ${priceString} Shipping
            </div>
          </div>
        </div>`
    });
    return html;
  }

  document.querySelector('.js-order-summary').innerHTML = cartSummaryHTML;

  let htmlStyleChange = (id, state1, state2) => {
    document.querySelector('.js-save-'+id).style.display = state1;
    document.querySelector('.js-input-update-'+id).style.display = state1;
    document.querySelector('.js-update-'+id).style.display = state2;
  };

  document.querySelectorAll('.js-delete-link').forEach((link) => {
    link.addEventListener('click', () => {
      const productId = link.dataset.productId;
      removeFromCart(productId);
      

      const container = document.querySelector('.js-cart-item-container-' + productId);

      //console.log(container);
      container.remove();
      renderPaymentSummary();
      renderCheckoutHeader();
    });
  });

  document.querySelectorAll('.js-update-link').forEach((link) => {
    const productId = link.dataset.productId;
    link.addEventListener('click', () => {
      //console.log("update");
      //console.log(productId);
      htmlStyleChange(productId, 'initial', 'none');
    });
  });

  document.querySelectorAll('.js-save-link').forEach((link) => {
    const productId = link.dataset.productId;
    link.addEventListener('click', ()=> {
      //console.log('save');
      //console.log(productId);
      htmlStyleChange(productId, 'none', 'initial');
      const updatedQuantity = Number(document.querySelector(`.js-input-update-${productId}`).value);
      document.querySelector(`.js-input-update-${productId}`).value = "";
      //console.log(updateNumber);
      if(updatedQuantity > 0){
        updateProductQuantity(productId, updatedQuantity);
        renderOrderSummary();
        renderPaymentSummary();
        renderCheckoutHeader();
      }else{
        alert("invaild input");
      }
      
    });
  });

  document.querySelectorAll('.js-quantity-input').forEach((input)=>{
    const productId = input.dataset.productId;
    input.addEventListener('keydown', (Event)=> {
      if(Event.key === 'Enter'){
        //let pQuantity = document.querySelector('')
        console.log(productId);
        htmlStyleChange(productId, 'none', 'initial');
        const updatedQuantity = Number(document.querySelector(`.js-input-update-${productId}`).value);
        document.querySelector(`.js-input-update-${productId}`).value = "";
        //console.log(updateNumber);
        if(updatedQuantity > 0){
          updateProductQuantity(productId, updatedQuantity);
          renderOrderSummary();
          renderPaymentSummary();
          renderCheckoutHeader();
        }else{
          alert("invaild input");
        }
      }
    });
  });

  document.querySelectorAll('.js-delivery-option').forEach((element)=>{
    element.addEventListener('click', ()=>{
      const {productId, deliveryOptionId} = element.dataset;
      updateDeliveryOption(productId, deliveryOptionId);
      renderOrderSummary();
      renderPaymentSummary();
    });
  });
}
