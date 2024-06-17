import React from 'react'
import FeatureFlagGlobalState from './context'
import FeatureFlags from '.'

const UseContextTest = () => {
  return (
    <div>
      <FeatureFlagGlobalState>
        <FeatureFlags />
      </FeatureFlagGlobalState>
    </div>
  )
}

export default UseContextTest
