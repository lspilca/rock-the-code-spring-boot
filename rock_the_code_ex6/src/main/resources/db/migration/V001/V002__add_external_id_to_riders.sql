ALTER TABLE riders
    ADD COLUMN external_id UUID NOT NULL DEFAULT gen_random_uuid();

ALTER TABLE riders
    ADD CONSTRAINT uk_riders_external_id UNIQUE (external_id);
