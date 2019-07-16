
Pod::Spec.new do |s|
  s.name         = "RNRegionsOverlay"
  s.version      = "1.0.0"
  s.summary      = "RNRegionsOverlay"
  s.description  = <<-DESC
                  RNRegionsOverlay
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "Alex Polomcak" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/Lipo11/react-native-regions-overlay.git", :tag => "master" }
  s.source_files  = "RNRegionsOverlay/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end
