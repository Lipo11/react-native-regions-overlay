#import <UIKit/UIKit.h>
#import <React/RCTView.h>
#import <React/UIView+React.h>
#import <React/RCTLog.h>
#import "RNTRegionsOverlay.h"

@implementation RNTRegionsOverlay

- (instancetype)init
{
    if( (self = [super init]) )
    {
    }
    
    return self;
}

- (void)drawRect:(CGRect)rect
{
    [super drawRect:rect];
    
    [[UIColor colorWithRed:0 green:0 blue:0 alpha:0.85] setFill];
    UIRectFill(rect);
    
    CGContextRef context = UIGraphicsGetCurrentContext();
    CGContextSetBlendMode(context, kCGBlendModeDestinationOut);
    
    for( NSDictionary * region in self.regions )
    {
        NSDictionary * position = [region objectForKey:@"position"];
        CGFloat width = 0;
        CGFloat height = 0;
        
        if( [position objectForKey:@"radius"] != nil )
        {
            width = [[position objectForKey:@"radius"] floatValue];
            height = [[position objectForKey:@"radius"] floatValue];
        }
        else
        {
            width = [[position objectForKey:@"width"] floatValue];
            height = [[position objectForKey:@"height"] floatValue];
        }
        
        UIBezierPath * path = nil;
        CGRect pathRect = CGRectMake([[position objectForKey:@"x"] floatValue], [[position objectForKey:@"y"] floatValue], width, height);
        
        if( [[region objectForKey:@"type"] isEqualToString:@"rect"] )
        {
            path = [UIBezierPath bezierPathWithRect:pathRect];
        }
        else if( [[region objectForKey:@"type"] isEqualToString:@"circle"] )
        {
            path = [UIBezierPath bezierPathWithOvalInRect:pathRect];
        }
        
        [path fill];
    }
    
    CGContextSetBlendMode(context, kCGBlendModeNormal);
}

@end
