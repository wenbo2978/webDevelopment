export function formatCurrency(priceCenter){
  return (Math.round(priceCenter) / 100).toFixed(2);
}