'use strict';

import { PropTypes } from 'prop-types';
import { requireNativeComponent, View } from 'react-native';

module.exports = requireNativeComponent('RNTRegionsOverlay', {
	name: 'RNTRegionsOverlay',
	propTypes: {
		regions: PropTypes.array,
		...View.propTypes // include the default view properties
	}
});
