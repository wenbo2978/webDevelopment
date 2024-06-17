//this is just data and an Api for geting the data


const dummyApiResponse = {
  showLightAndDarkMode : true,
  showTicTacToeBoard : true,
  showRandomColorGenerator : true,
  showAccordian : false,
  showTreeView : true
}

function featureFlagDataServiceCall(){
  return new Promise((resolve, reject) => {
    if(dummyApiResponse)
      setTimeout(resolve(dummyApiResponse), 500);
    else
      reject('some error occured!');
  })
}

export default featureFlagDataServiceCall;