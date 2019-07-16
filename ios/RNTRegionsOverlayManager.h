#ifndef RNTRegionsOverlayManager_h
#define RNTRegionsOverlayManager_h

#import <React/RCTViewManager.h>
#import "RNTRegionsOverlay.h"

@interface RNTRegionsOverlayManager : RCTViewManager

@property (strong) RNTRegionsOverlay *overlay;

@end

#endif /* RNTRegionsOverlayManager_h */
