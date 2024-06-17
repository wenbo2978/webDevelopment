import React, { useState } from 'react'
import Modal from './modal';

const ModalTest = () => {
  const [showModalPopup, setShowModalPopup] = useState(false);
  const handleToggleModalPopup = () => {
    setShowModalPopup(!showModalPopup);
  }

  function onClose(){
    setShowModalPopup(false);
  }

  return (
    <div style={{
      display: "flex",
      flexDirection: "column",
      alignItems: "center"
    }}>
      <button 
        style={{
          margin: "10px"
        }}
        onClick={handleToggleModalPopup}
      >Open Modal Popup</button>
      {
        showModalPopup && <Modal
          body={<div>Customized Body</div>}
          onClose={onClose}
        />
      }
    </div>
  )
}

export default ModalTest
