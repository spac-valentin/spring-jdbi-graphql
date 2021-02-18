--
-- Insert
--
update vehicle set
    model_code=:modelCode,
    color=:color,
    brand_id=:brandId
	where id=:id
