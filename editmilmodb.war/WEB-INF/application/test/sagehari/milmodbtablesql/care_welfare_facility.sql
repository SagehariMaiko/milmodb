USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.care_welfare_facility(
	office_id int NOT NULL,
	nitijyokeizoku BIT NULL,
	kangotaisei_1 BIT NULL,
	kangotaisei_2 BIT NULL,
	nightdutyhaichi BIT NULL,
	semi_unitcare BIT NULL,
	private_kinou BIT NULL,
	jyakunenseinyusyo BIT NULL,
	doctor_haiti BIT NULL,
	seishinkairyo BIT NULL,
	syogaisyashien BIT NULL,
	taisyomaesoudan BIT NULL,
	taisyogosoudan BIT NULL,
	taisyojisoudan BIT NULL,
	taisyomaerenkei BIT NULL,
	eiyomanage BIT NULL,
	keikoikou BIT NULL,
	keikoiji BIT NULL,
	koukutaisei BIT NULL,
	kouku BIT NULL,
	medical_meal BIT NULL,
	caregiving BIT NULL,
	zaitakuhukki BIT NULL,
	zaitakunyusyo BIT NULL,
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
