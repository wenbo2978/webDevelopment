import React, { useState } from 'react'
import QRCode from 'react-qr-code'

const QRCodeGenerator = () => {
  const [qrCode, setQrCode] = useState('');
  const [input, setInput] = useState('');
  return (
    <div>
      <h1>QR Code Generator</h1>
      <div>
        <input 
          type='text' 
          name='qr-code' 
          placeholder='Enter your name here'
          onChange={(e) => setInput(e.target.value)}
        />
        <button 
          onClick={()=> setQrCode(input)}
          disabled={!input && input.trim() === ''}  
        >Generate</button>
      </div>
      <div>
        <QRCode 
          id='qr-code-value'
          value={qrCode}
        />
      </div>
    </div>
  )
}

export default QRCodeGenerator
