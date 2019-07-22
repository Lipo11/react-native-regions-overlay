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
        const regions = [
            { position: { x: 10, y: 10, radius: 20 }, type: 'circle' },
            { position: { x: 50, y: 50, width: 20, height: 20 }, type: 'rect' }
        ];

        return (
            <View style={{ flex: 1, backgroundColor: 'blue' }}>
                <RNRegionsOverlay style={{ flex: 1, backgroundColor: 'rgba(0, 0, 0, 0.5)' }} regions={ regions } />
            </View>
        );
    }
}
```

### API

#### style
Style for mask view.
#### regions
Regions is an array with object position (x, y) and type ( circle, rect ).