# React native regions overlay
Circle & rect mask for your view

### Installing
```
npm install react-native-regions-overlay --save
- or -
yarn add react-native-regions-overlay
```

### Usage
```
import React from 'react';
import RNRegionsOverlay from 'react-native-regions-overlay';

export default class Example extends React.Component
{
    render() {
        const regions = [ { position: { x: 10, y: 10, radius: 10 }, type: 'circle' }, { position: { x: 10, y: 10, width: 10, height: 10 }, type: 'rect' } ];

        return (
            <View style={{ flex:1, backgroundColor: 'blue' }}>
                <RNRegionsOverlay style={{ flex:1, backgroundColor: 'rgba(0, 0, 0, 0.5)' }} regions={ regions } />
            </View>
        );
    }
}
```