USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.home_rehabilitation(
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
	from_service_time_week NVARCHAR(4) NULL,
	to_service_time_week NVARCHAR(4) NULL,
	from_service_time_sat NVARCHAR(4) NULL,
	to_service_time_sat NVARCHAR(4) NULL,
	from_service_time_sun NVARCHAR(4) NULL,
	to_service_time_sun NVARCHAR(4) NULL,
	from_service_time_hol NVARCHAR(4) NULL,
	to_service_time_hol NVARCHAR(4) NULL,
	service_time_memo NVARCHAR(MAX) NULL,
	service_area NVARCHAR(MAX) NULL,
	houmonkangorenkei BIT NULL,
	service_supply BIT NULL,
	outarea_price NVARCHAR(MAX) NULL,
	cancel_price NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
