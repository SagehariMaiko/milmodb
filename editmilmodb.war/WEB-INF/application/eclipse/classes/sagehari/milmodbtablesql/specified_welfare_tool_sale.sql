USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.specified_welfare_tool_sale(
	office_id int NOT NULL,
	from_office_time_week NVARCHAR(4) NULL,
	to_office_time_week NVARCHAR(4) NULL,
	from_office_time_sat NVARCHAR(4) NULL,
	to_office_time_sat NVARCHAR(4) NULL,
	from_office_time_sun NVARCHAR(4) NULL,
	to_office_time_sun NVARCHAR(4) NULL,
	from_office_time_hol NVARCHAR(4) NULL,
	to_office_time_hol NVARCHAR(4) NULL,
	office_time_reghol NVARCHAR(MAX) NULL,
	office_time_memo NVARCHAR(MAX) NULL,
	service_area NVARCHAR(20) NULL,
	chairtoilet BIT NULL,
	chairtoilet_price_from INT NOT NULL,
	chairtoilet_price_to INT NOT NULL,
	autoexcretionparts BIT NULL,
	autoexcretionparts_price_from INT NOT NULL,
	autoexcretionparts_price_to INT NOT NULL,
	bathchair BIT NULL,
	bathchair_price_from INT NOT NULL,
	bathchair_price_to INT NOT NULL,
	bathtubhandrail BIT NULL,
	bathtubhandrail_price_from INT NOT NULL,
	bathtubhandrail_price_to INT NOT NULL,
	bathtubchair BIT NULL,
	bathtubchair_price_from INT NOT NULL,
	bathtubchair_price_to INT NOT NULL,
	bathstand BIT NULL,
	bathstand_price_from INT NOT NULL,
	bathstand_price_to INT NOT NULL,
	bathroomsunoko BIT NULL,
	bathroomsunoko_price_from INT NOT NULL,
	bathroomsunoko_price_to INT NOT NULL,
	bathtubsunoko BIT NULL,
	bathtubsunoko_price_from INT NOT NULL,
	bathtubsunoko_price_to INT NOT NULL,
	bathassistbelt BIT NULL,
	bathassistbelt_price_from INT NOT NULL,
	bathassistbelt_price_to INT NOT NULL,
	simplebath BIT NULL,
	simplebath_price_from INT NOT NULL,
	simplebath_price_to INT NOT NULL,
	liftsling BIT NULL,
	liftsling_price_from INT NOT NULL,
	liftsling_price_to INT NOT NULL,
	outarea_price NVARCHAR(MAX) NULL,
	welfaretoolcarry_price NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
