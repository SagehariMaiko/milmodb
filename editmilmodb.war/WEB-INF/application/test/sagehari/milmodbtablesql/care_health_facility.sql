USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.care_health_facility(
	office_id int NOT NULL,
	nightdutyhaichi BIT NULL,
	tankirehabili BIT NULL,
	nintisyotankirehabili BIT NULL,
	nintisyocare BIT NULL,
	jyakunenseinyusyo BIT NULL,
	zaitakuhukkiryoyo BIT NULL,
	caregiving BIT NULL,
	ryoyoiji_2 BIT NULL,
	nyusyozengoshido BIT NULL,
	taisyomaeshido BIT NULL,
	taisyogoshido BIT NULL,
	taisyojishido BIT NULL,
	taisyojiinfo BIT NULL,
	taisyomaerenkei BIT NULL,
	roujinkangoshiji BIT NULL,
	eiyomanage BIT NULL,
	keikoikou BIT NULL,
	keikoiji BIT NULL,
	koukutaisei BIT NULL,
	kouku BIT NULL,
	medical_meal BIT NULL,
	zaitakuhukki BIT NULL,
	kinkyujiryoyo BIT NULL,
	syoteishikkan BIT NULL,
	nintisyosenmon_1 BIT NULL,
	nintisyosenmon_2 BIT NULL,
	nintisyoshinritaio BIT NULL,
	nintisyoinfo BIT NULL,
	localrenkeikeikaku BIT NULL,
	service_supply_1 BIT NULL,
	service_supply_2 BIT NULL,
	service_supply_3 BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	entrance_capacity INT NOT NULL,
	care_health_facility BIT NULL,
	satellite_small_carehealth BIT NULL,
	medical_small_carehealth BIT NULL,
	unit_privateroom BIT NULL,
	unit_semi_privateroom BIT NULL,
	existingroom BIT NULL,
	multibedroom BIT NULL,
	meal_price NVARCHAR(MAX) NULL,
	residence_price NVARCHAR(MAX) NULL,
	special_nursing_price NVARCHAR(MAX) NULL,
	special_meal_price NVARCHAR(MAX) NULL,
	hairdressing_price NVARCHAR(MAX) NULL,
	daily_life_price NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
