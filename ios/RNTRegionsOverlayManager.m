#import <React/RCTLog.h>
#import "RNTRegionsOverlayManager.h"
#import "RNTRegionsOverlay.h"

@implementation RNTRegionsOverlayManager

RCT_EXPORT_MODULE()

#pragma mark - Properties

RCT_EXPORT_VIEW_PROPERTY(regions, NSArray)

#pragma mark - Lifecycle

- (UIView *)view
{
    RNTRegionsOverlay * view;
    view = [[RNTRegionsOverlay alloc] init];
    return view;
}

@end
