USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.care_medical_facility(
	office_id int NOT NULL,
	office_kubun NVARCHAR(30) NULL,
	nightkango_1 BIT NULL,
	nightkango_2 BIT NULL,
	nightkango_3 BIT NULL,
	nightkango_4 BIT NULL,
	nothing_add BIT NULL,
	ryoyobyousyo BIT NULL,
	nintisyobyoto BIT NULL,
	jyakunenseikanjya BIT NULL,
	gaihaku BIT NULL,
	shikotekitaiinn BIT NULL,
	takajyushin BIT NULL,
	taiinmaeshido BIT NULL,
	taiingoshido BIT NULL,
	taiinjishido BIT NULL,
	taiinjiinfo BIT NULL,
	taiinmaerenkei BIT NULL,
	roujinkangoshiji BIT NULL,
	eiyomanage BIT NULL,
	keikoikou BIT NULL,
	keikoiji BIT NULL,
	koukutaisei BIT NULL,
	kouku BIT NULL,
	medical_meal BIT NULL,
	zaitakuhukki BIT NULL,
	tokuteishinryo BIT NULL,
	nintisyosenmon_1 BIT NULL,
	nintisyosenmon_2 BIT NULL,
	nintisyoshinritaio BIT NULL,
	service_supply_1 BIT NULL,
	service_supply_2 BIT NULL,
	service_supply_3 BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	entrance_capacity INT NOT NULL,
	unit_privateroom BIT NULL,
	unit_semi_privateroom BIT NULL,
	existingroom BIT NULL,
	multibedroom BIT NULL,
	meal_price NVARCHAR(MAX) NULL,
	residence_price NVARCHAR(MAX) NULL,
	special_sickroom_price NVARCHAR(MAX) NULL,
	special_meal_price NVARCHAR(MAX) NULL,
	hairdressing_price NVARCHAR(MAX) NULL,
	daily_life_price NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
