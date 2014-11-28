USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.welfare_tool_rental(
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
	service_area NVARCHAR(MAX) NULL,
	wheelchair BIT NULL,
	wheelchair_price_from INT NOT NULL,
	wheelchair_price_to INT NOT NULL,
	specialbed BIT NULL,
	specialbed_price_from INT NOT NULL,
	specialbed_price_to INT NOT NULL,
	bedsore BIT NULL,
	bedsore_price_from INT NOT NULL,
	bedsore_price_to INT NOT NULL,
	phyconverter BIT NULL,
	phyconverter_price_from INT NOT NULL,
	phyconverter_price_to INT NOT NULL,
	handrail BIT NULL,
	handrail_price_from INT NOT NULL,
	handrail_price_to INT NOT NULL,
	slope BIT NULL,
	slope_price_from INT NOT NULL,
	slope_price_to INT NOT NULL,
	walker BIT NULL,
	walker_price_from INT NOT NULL,
	walker_price_to INT NOT NULL,
	walkstick BIT NULL,
	walkstick_price_from INT NOT NULL,
	walkstick_price_to INT NOT NULL,
	dementialoiter BIT NULL,
	dementialoiter_price_from INT NOT NULL,
	dementialoiter_price_to INT NOT NULL,
	lift BIT NULL,
	lift_price_from INT NOT NULL,
	lift_price_to INT NOT NULL,
	autoexcretion BIT NULL,
	autoexcretion_price_from INT NOT NULL,
	autoexcretion_price_to INT NOT NULL,
	outarea_price NVARCHAR(MAX) NULL,
	welfaretoolcarry_price NVARCHAR(MAX) NULL,
	cancel_price NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
