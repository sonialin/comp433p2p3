INSERT INTO `ProductOwner` (`ProductOwnerName`, `ProductOwnerType`) 
VALUES ('Amazon', 'Platform');

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Kindle Paperwhite E-reader - Black, 6\" High-Resolution Display (300 ppi) with Built-in Light, Wi-Fi - Includes Special Offers', 
119.99, 'Page Flip makes it easy to find pictures, charts, maps and even your notes and highlights from different parts of a book. While you swipe to other pages or zoom out to see page thumbnails, Page Flip automatically saves the page you’re reading, pinning it to the side of your screen so you’ll never lose your place.', 
1, 10);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Kindle Voyage E-reader, 6" High-Resolution Display (300 ppi) with Adaptive Built-in Light, PagePress Sensors, Wi-Fi - Includes Special Offers', 
199.99, 'Kindle Voyage features a high-resolution 300 ppi display for crisp, laser quality text. The micro-etched glass screen is crafted to eliminate glare and feel like paper to the touch.', 
1, 5);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Fire Tablet, 7" Display, Wi-Fi, 8 GB - Includes Special Offers, Black', 
49.99, 'The fast quad-core processor consists of four high-performance 1.3 GHz cores for quick app launches, smooth games and videos, and great overall performance.', 
1, 20);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Fire HD 6 Tablet, 6" HD Display, Wi-Fi, 8 GB - Includes Special Offers, Black', 
69.99, 'Amazon engineers Fire HD tablets to hold up against everyday life. When tested against iPad mini 4 in tumble tests, Fire HD 6 proved 2x more durable.
Real scenarios, real tablets. The scenarios in our latest commercial were shot in real time using our real tablets. The drop test happens so fast that we had to slow it down using a high speed camera to show the more than 3,300 Newtons of force at the moment of impact.', 
1, 15);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Fire HD 10 Tablet, 10.1" HD Display, Wi-Fi, 16 GB - Includes Special Offers, Silver Aluminum', 
229.99, 'Fast and responsive. The fast quad-core processor consists of two high-performance 1.5 GHz cores and two 1.2 GHz cores running simultaneously for quick app launches, smooth games and videos, and great overall performance.', 
1, 8);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('All-New Fire HD 8 Tablet, 8" HD Display, Wi-Fi, 16 GB - Includes Special Offers, Black', 
89.99, 'Fast and responsive. Enjoy your entertainment with a fast 1.3 GHz quad-core processor. Fire HD 8 now delivers faster performance thanks to a 50% increase in RAM over the previous model.', 
1, 12);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Fire Kids Edition Tablet, 7" Display, Wi-Fi, 16 GB, Blue Kid-Proof Case', 
99.99, 'Latest generation Fire Tablet. A full-featured 7" Fire tablet with a 1024 x 600 IPS display that\'s perfect for watching movies like Frozen, plus a fast quad-core processor that ensures quick app launch times and smooth games and video. The Fire Kids Edition tablet comes in black (with a blue, pink, or green Kid-Proof Case), 8 GB or 16 GB of internal storage, and up to 128 GB of expandable storage with microSD.', 
1, 20);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('All-New Fire TV Stick with Alexa Voice Remote | Streaming Media Player', 
39.99, 'Just plug Fire TV Stick into your HDTV and start streaming in minutes. Use the included Alexa Voice Remote to find the best way to watch across more than 90 channels and apps with universal search. With the fastest Wi-Fi and most accurate voice search of any streaming media stick, shows and movies start faster and stream smoother than ever.', 
1, 20);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Amazon Fire TV | Streaming Media Player', 
99.99, 'Now with 4K Ultra HD
Amazon Fire TV now brings you 4K Ultra HD streaming capability, giving you a best-in-class television experience with true-to-life picture quality when used with compatible 4K Ultra HD TVs—something Apple TV and Chromecast don’t support. Your 4K TV must support minimum HDCP requirements for protected content playback.', 
1, 5);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Amazon Fire TV | Streaming Media Player', 
109.99, 'The Amazon Fire TV + HD Antenna Bundle comes with three separate products: Amazon Fire TV, an AmazonBasics Ultra Thin Indoor HDTV Antenna, and an AmazonBasics HDMI Cable (6 feet). When you use these devices together, you can access great television shows and movies without cable. Fire TV lets you stream TV shows and movies from Amazon Video, Netflix, HBO NOW, and more, while the AmazonBasics HD Antenna receives free over-the-air HD local broadcast content from stations like ABC, CBS, NBC, and FOX.', 
1, 8);

INSERT INTO `ProductOwner` (`ProductOwnerName`, `ProductOwnerType`) 
VALUES ('Samsung', 'Partner');

INSERT INTO `ProductOwner` (`ProductOwnerName`, `ProductOwnerType`) 
VALUES ('HTC', 'Partner');

INSERT INTO `Partner` (`PartnerName`, `PartnerType`, `Pasword`, `Username`, `ProductOwner_ProductOwnerID`) 
VALUES ("Samsung", "Company", "123456", "samsung", 2);

INSERT INTO `Partner` (`PartnerName`, `PartnerType`, `Pasword`, `Username`, `ProductOwner_ProductOwnerID`) 
VALUES ("HTC", "Company", "123456", "htc", 3);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Samsung Galaxy J5 SM-J500H/DS GSM Factory Unlocked Smartphone, International Version (Gold)', 
159.49, 'Samsung Galaxy J5 SM-J500H/DS GSM Factory Unlocked Smartphone, International Version (White) no Warranty 2G Bands: GSM 850/900/1800/1900 3G Bands: 850/900/1900/2100 5.0" Super AMOLED Capacitive Multi-Touchscreen w/ Protective Corning Gorilla Glass Android OS, v5.1 (Lollipop), Quad-core 1.2 GHz Adreno 306 Processor, Chipset: Qualcomm MSM8916 13MP Primary Camera autofocus LED flash, 5.0MP Front Camera LED flash 8GB Internal Memory, Dual Sim Card', 
2, 10);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('Samsung Galaxy S7 Edge Factory Unlocked Phone 32 GB - International Version G935F- Platinum Gold', 
609.00, 'Fast battery charging: 60% in 30 min (Quick Charge 2.0); Wireless charging (Qi/PMA) ; market dependent; ANT+ support; S; Voice natural language commands and dictation; OneDrive (115 GB cloud storage); Active noise cancellation with dedicated mic; MP4/DivX/XviD/WMV/H.264 player; MP3/WAV/WMA/eAAC+/FLAC player; Photo/video editor; Document editor.', 
2, 9);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('HTC One A9 Unlocked 16GB 4g LTE 5.0-inch - International Version (Carbon Gray)', 
294.30, 'From the company that crafted the world\'s first all-metal design, HTC again sets a new design standard. The HTC One A9 features a super-thin metal frame with an elegant finish, expandable SD card memory and edge-to-edge Corning® Gorilla® Glass 4. Unleash your inner photographer with the HTC One A9. Take blur-free photos with Optical Image Stabilisation (OIS). Save more image details for unsurpassed editing and creative control with RAW capture in Pro mode. Speed up your videos up to 12x for a dramatic effect with Hyperlapse.', 
3, 15);

INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) 
VALUES ('HTC One A9 Factory Unlocked Smartphone, 32GB 4G LTE 5-Inch HD Display (International Stock No Warranty), Gray', 
330.00, 'From the company that crafted the world\'s first all-metal design, HTC again sets a new design standard. The HTC One A9 features a super-thin metal frame with an elegant finish, expandable SD card memory and edge-to-edge Corning Gorilla Glass.', 
3, 20);

INSERT INTO `Customer` (`Username`, `Password`, `Firstname`, `Lastname`, `Email`) 
VALUES ('sonialin', '123456', 'Sonia', 'Lin', 'jlin7@luc.edu');
INSERT INTO `Customer` (`Username`, `Password`, `Firstname`, `Lastname`, `Email`) 
VALUES ('AshleyLiu', '654321', 'Ashley', 'Liu', 'tliu6@luc.edu');

INSERT INTO `OrderStatus` (`StatusName`, `StatusID`) VALUES ('Paid', 1);
INSERT INTO `OrderStatus` (`StatusName`, `StatusID`) VALUES ('Processed', 2);
INSERT INTO `OrderStatus` (`StatusName`, `StatusID`) VALUES ('Shipped', 3);
INSERT INTO `OrderStatus` (`StatusName`, `StatusID`) VALUES ('Delivered', 4);
INSERT INTO `OrderStatus` (`StatusName`, `StatusID`) VALUES ('Cancelled', 5);
INSERT INTO `OrderStatus` (`StatusName`, `StatusID`) VALUES ('Refunded', 6);

INSERT INTO `Cart` (`CartPrice`, `Tax`) VALUES (159.49, 9.97);
INSERT INTO `CartLineItem` (`Cart_CartID`, `Product_ProductID`, `CartLineItemQuantity`, `CartLineItemPrice`) 
VALUES (1, 11, 1, 159.49);

INSERT INTO `Order` (`OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID`, `Cart_CartID`) 
VALUES (169.46, 'sonialin', 20160930, 1, 1);

INSERT INTO `Payment` (`CardType`, `CardNumber`, `ExpirationDate`, `SecurityCode`, `BillingName`, `Order_OrderID`)
VALUES ('Visa', '1234223432344234', 20170501, 999, 'Sonia Lin', 1);

INSERT INTO `ProductReview` (`ProductReviewContent`, `Rating`, `ProductReviewDate`, `Product_ProductID`, `Customer_Username`)
VALUES ('Great phone and arrived on time.', 5, CURRENT_TIMESTAMP, 11, 'sonialin');

INSERT INTO `ProductReview` (`ProductReviewContent`, `Rating`, `ProductReviewDate`, `Product_ProductID`, `Customer_Username`)
VALUES ('Love this phone, good looking and easy to use', 5, CURRENT_TIMESTAMP, 11, 'AshleyLiu');

INSERT INTO `ecommerce`.`Address` (`StreetAddressLine1`, `StreetAddressLine2`, `City`, `State`, `Zipcode`, `Partner_PartnerID`, `Customer_Username`, `Order_OrderID`, `Payment_Order_OrderID`)
VALUES ('200 S Frontage Rd', NULL, 'Burr Ridge', 'IL', '60527', 1, NULL, NULL, NULL);

INSERT INTO `ecommerce`.`Address` (`StreetAddressLine1`, `StreetAddressLine2`, `City`, `State`, `Zipcode`, `Partner_PartnerID`, `Customer_Username`, `Order_OrderID`, `Payment_Order_OrderID`)
VALUES ('1032 W Sheridan Rd', NULL, 'Chicago', 'IL', '60660', NULL, 'sonialin', NULL, NULL);

INSERT INTO `ecommerce`.`Address` (`StreetAddressLine1`, `StreetAddressLine2`, `City`, `State`, `Zipcode`, `Partner_PartnerID`, `Customer_Username`, `Order_OrderID`, `Payment_Order_OrderID`)
VALUES ('6655 N Sheridan Rd', NULL, 'Chicago', 'IL', '60626', NULL, NULL, 1, NULL);

INSERT INTO `ecommerce`.`Address` (`StreetAddressLine1`, `StreetAddressLine2`, `City`, `State`, `Zipcode`, `Partner_PartnerID`, `Customer_Username`, `Order_OrderID`, `Payment_Order_OrderID`) 
VALUES ('1032 W Sheridan Rd', NULL, 'Chicago', 'IL', '60660', NULL, NULL, NULL, 1);

INSERT INTO `ecommerce`.`Address` (`StreetAddressLine1`, `StreetAddressLine2`, `City`, `State`, `Zipcode`, `Partner_PartnerID`, `Customer_Username`, `Order_OrderID`, `Payment_Order_OrderID`)
VALUES ('13920 Southeast Eastgate Way #200', NULL, 'BelleVue', 'WA', '98005', 2, NULL, NULL, NULL);

INSERT INTO `ecommerce`.`PhoneNumber` (`AreaCode`, `Number`, `Partner_PartnerID`, `Customer_Username`) 
VALUES ('630', '5683072', 1, NULL);

INSERT INTO `ecommerce`.`PhoneNumber` (`AreaCode`, `Number`, `Partner_PartnerID`, `Customer_Username`) 
VALUES ('425', '6795318', 2, NULL);

INSERT INTO `ecommerce`.`PhoneNumber` (`AreaCode`, `Number`, `Partner_PartnerID`, `Customer_Username`)
VALUES ('312', '9812123', NULL, 'sonialin');