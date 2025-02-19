import Foundation
import MarkdownUI
import NetworkImage
import SwiftUI

public struct EmojiInlineImageProvider: InlineImageProvider {
    var emojiSize: CGFloat = 14
    public func image(with url: URL, label: String) async throws -> Image {
        let img = try await DefaultNetworkImageLoader.shared.image(from: url)
        #if os(macOS)
            let uiimg = UIImage(cgImage: img, size: .init(width: emojiSize, height: emojiSize))
            return .init(nsImage: uiimg)
        #else
            return if let uiimg = UIImage(cgImage: img).resize(height: emojiSize) {
                Image(uiImage: uiimg)
            } else {
                Image(
                    img,
                    scale: 1,
                    label: Text(label)
                )
            }
        #endif
    }
}

public extension InlineImageProvider where Self == EmojiInlineImageProvider {
    static var emoji: Self {
        .init()
    }

    static var emojiSmall: Self {
        .init(emojiSize: 10)
    }
}

#if os(iOS)
    extension UIImage {
        func resize(height: CGFloat) -> UIImage? {
            let heightRatio = height / size.height
            let width = size.width * heightRatio

            let resizedSize = CGSize(width: width, height: height)

            UIGraphicsBeginImageContextWithOptions(resizedSize, false, 0.0)
            draw(in: CGRect(origin: .zero, size: resizedSize))
            let resizedImage = UIGraphicsGetImageFromCurrentImageContext()
            UIGraphicsEndImageContext()

            return resizedImage
        }
    }
#endif
