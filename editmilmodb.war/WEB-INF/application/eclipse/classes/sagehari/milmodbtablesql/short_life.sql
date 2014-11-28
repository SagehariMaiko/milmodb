USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.short_life(
	office_id int NOT NULL,
	office_type NVARCHAR(30) NULL,
	sub_kinoukunrenshidoin BIT NULL,
	kinoukunrentaisei_yobo BIT NULL,
	sub_kangotaisei_1 BIT NULL,
	sub_kangotaisei_2 BIT NULL,
	sub_nightdutyhaichi BIT NULL,
	nintisyoshinritaio BIT NULL,
	jyakunenseiriyo BIT NULL,
	sougei_2 BIT NULL,
	sub_kinkyutankitaisei BIT NULL,
	sub_kinkyutankiuke BIT NULL,
	medical_meal BIT NULL,
	sub_zaitakuuke BIT NULL,
	service_supply_1 BIT NULL,
	service_supply_2 BIT NULL,
	service_supply_3 BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	unit_privateroom BIT NULL,
	unit_semi_privateroom BIT NULL,
	existingroom BIT NULL,
	multibedroom BIT NULL,
	meal_price NVARCHAR(MAX) NULL,
	stay_price_2 NVARCHAR(MAX) NULL,
	special_room_price NVARCHAR(MAX) NULL,
	special_meal_price NVARCHAR(MAX) NULL,
	hairdressing_price NVARCHAR(MAX) NULL,
	daily_life_price NVARCHAR(MAX) NULL,
	userchargecut BIT NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
