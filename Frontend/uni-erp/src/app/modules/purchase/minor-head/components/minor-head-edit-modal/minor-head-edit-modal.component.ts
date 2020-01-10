import { MajorHeadService } from './../../../../../core/services/Purchase/major-head.service';
import { MinorHeadService } from './../../../../../core/services/Purchase/minor-head.service';
import { Component, OnInit, Input } from '@angular/core';
import { MinorHead } from 'src/app/core/models/Purchase/minor-head';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-minor-head-edit-modal',
  templateUrl: './minor-head-edit-modal.component.html',
  styleUrls: ['./minor-head-edit-modal.component.less']
})
export class MinorHeadEditModalComponent implements OnInit {

	@Input() minorHd: MinorHead;
	majorHeads: any = [];
  constructor(
		private minorHeadService: MinorHeadService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private majorHeadService: MajorHeadService
	) { }

  ngOnInit() {
		this.getAllMajorHead();
	}
	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateMinorHead(){
		this.minorHeadService.updateMinorHead(this.minorHd.id, this.minorHd).subscribe(
			data => {
				this.message.create('success', `Minor Head Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Minor Head Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

	public getAllMajorHead(){
		this.majorHeadService.getAllMajorHead().subscribe(
				data => {
						this.majorHeads = data;


				},
				error => {

					if(error['status']=='404'){
						this.majorHeads = [];
					}
						else if(error.error){
						this.majorHeads = error.error;
				}

				}
		);
	}

}
